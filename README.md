真·函数化包。
不同于其他使用几个函数方法的包，该包尽可能把函数式的抽象方式引进，哪怕效率下降，也要把代码抽象到极致，然后再反过来按需硬编码提速。

0.0.0<br/>
提供一些常用函数

0.0.1<br/>
把Tuple构造t函数放到Tuple

0.0.2<br/>
把Collection中的函数整理到JList,JSet,JMap<br/>
增加Tuple模式匹配函数

0.0.3<br/>
增加static初始化的高阶描述形式

0.0.4<br/>
增加 tuple toString <br/>
增加 PatternMatch接口，方便底层处理<br/>
增加 Func作为所有函数统一抽象，默认一个apply方法，但不建议直接使用<br/>
增加 ClosureWrapper的funcWrapper其他参数组合

0.0.5(开始提交版本/submit version)<br/>
实现模式匹配函数Matcher，方便具有模式匹配特性的数据结构使用
Either大幅改动(break change)
BooleanFucntion EitherFunction改成