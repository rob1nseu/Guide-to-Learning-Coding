# **Linux-Pthread 学习**

## **pthread线程库**

>  示例见WSL中 /home/robin/pthread_test



#### 1. 多线程函数，参数泛化

​	返回值必须为void\*，形参必须为void\*.**（示例见 5.线程同步 代码块`thread_func`函数）**



#### 2. pthread_create 线程创建

- pthread_create( pthread*, attr*(一般为NULL), 返回类型为void*的函数, 类型为void*的传递数据形参 )`

- 类型为void\*的形参一般新建结构体(装入所需参数)，并类型转换为（void\*）



#### 3. pthread_join/exit 线程等待/销毁

- `pthread_join(pthread_t thread, void **__thread_return)`
- `pthread_exit()`与`return`的唯一不同：主线程 `return` 会结束整个进程 ; 主线程调用`pthread_exit()`会退出但进程继续运行.



#### 4. 线程创建/等待/销毁示例

```c
#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>

typedef struct {
    int thread_id;
    int left, right;
    int *arr;
} threadData;  // 创建线程所需传递的数据打包在threadData里


// 多线程函数，参数泛化：返回值必须为void*，形参必须为void*.
void* sum_array(void* arg){
    threadData* t_data = (threadData * )arg; // 解引用void*型的threadData(线程所传递的数据)
    long *result = malloc(sizeof(long));  // 动态分配内存，存放结果
    int * arr = t_data->arr;
    for(int i = t_data->left; i <= t_data->right ;i++){
        printf("thread[%d]\n",t_data->thread_id);
        *result+=arr[i];
    }
    return (void * )result;
}

int main(){
    // pthread_t的声明
    pthread_t thread[2];
    int arr[10]={1,2,3,4,5,6,7,8,9,10};
    int mid = (0+9)/2;

    // 多线程参数的构造
    threadData t_data[2];
    t_data[0].thread_id=0;
    t_data[0].left = 0;
    t_data[0].right = mid;
    t_data[0].arr = arr;

    t_data[1].thread_id=1;
    t_data[1].left = mid + 1;
    t_data[1].right = 9;
    t_data[1].arr = arr;
    // pthread_create(pthread*,attr*(一般为NULL),返回类型为void*的函数,类型为void*的函数形参)
    pthread_create(&thread[0],NULL,sum_array,(void*)(&t_data[0])); 
    pthread_create(&thread[1],NULL,sum_array,(void*)(&t_data[1]));

    // 当然也可以把待返回值写到threadData里，用指针在堆里返回.
    void * ret0, * ret1; 
    // pthread_join(pthread_t thread, void **__thread_return)
    pthread_join(thread[0], &ret0);
    pthread_join(thread[1], &ret1);

    // 转换回具体类型
    long sum1 = *(long*)ret0;
    long sum2 = *(long*)ret1;
    printf("Sum1: %ld, Sum2: %ld, Total: %ld\n", 
           sum1, sum2, sum1 + sum2);

    free(ret0);
    free(ret1);

    // gcc -o 输出文件名 源文件.c -lpthread
}
```



#### 5. 线程同步示例

```c
// `pthread_mutex_t` 类型，表示互斥锁（类似信号量）
#include <pthread.h>
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER; // 静态初始化

void *thread_func(void *arg) {
    pthread_mutex_lock(&mutex); // 加锁 (取地址转指针)
    // 临界区（Critical Section）：访问共享资源
    pthread_mutex_unlock(&mutex); // 解锁
    return NULL;
}

// 函数详解：

int pthread_mutex_lock(pthread_mutex_t *mutex);
// 如果锁未被占用，当前线程会立即获取锁，并继续执行。
// 如果锁已被其他线程占用，当前线程会阻塞，直到锁被释放（pthread_mutex_unlock）。

// 返回值：0：成功获取锁；非 0：获取锁失败（如锁已被占用、锁未初始化等）

// 配套解锁函数 pthread_mutex_unlock
int pthread_mutex_unlock(pthread_mutex_t *mutex);
```
