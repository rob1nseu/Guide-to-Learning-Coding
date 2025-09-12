package ch01.OOP_0401;

//Java中的异常处理 ——-保持程序的健壮与简洁
//      1）非常常见的运行期异常————不需要声明
//  如 NullException ArithmeticException 等
//  直接catch(Exception e) 即可
//  谁调用，谁处理异常！
//      2）try catch与 finally
//  try 检测异常        catch 捕获异常     finally 有没有异常都做的善后操作
//  Java的 finally 为优先级最高机制，甚至在 return 前执行，
//      3）函数头处，throws 将可能抛出的不太常见的异常抛出
//      4）异常链（异常栈
//  异常一级一级传递，有initCause()等方法寻找源异常，printStackTrace()打印异常栈
///
