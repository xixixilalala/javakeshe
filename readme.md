## SensitiveVocabularyAnalysis 
SensitiveVocabularyAnalysis部分通过AC自动机实现敏感词检测算法，在期望O(n)复杂度内进行敏感词检测

### VocabularyTable

VocabularyTable 是一个用于存储敏感词数据的类，提供空构造函数，插入字符串insert(String s)，插入字符串及其对应数字insert(String s,Integer i)，获取表大小size()，获取i位置的字符串stringAt(int i)，获取i位置的数字IntegerAt(int i)。

### ACM

ACM 提供一个AC自动机类，提供两个public的成员函数：构造函数和solve函数。构造函数输入一个VocabularyTable类敏感词表，用于构造AC自动机。solve函数传入一个待检测字符串s，返回一个敏感词表及其出现次数。

*待升级的功能：String filter(String s) 传入一个待过滤字符串，返回一个按照屏蔽规则将所有敏感词置为\*\*的字符串。*

已经实现 String sensitize(String) s 传入一个代过滤字符串，返回一个按照屏蔽规则将所有敏感词置为\*\*的字符串。

### SensitiveDectiveInterface

SensitiveDectiveInterface 提供一个接口，build(VocabularyTable vt)用vt构造AC自动鸡，solve(String s)输入待检测字符串，返回一个敏感词表。

### SensitiveDective

SensitiveDective 提供 SensitiveDectiveInterface 的实现，功能不再重复叙述。

