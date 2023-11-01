# Вариант 511

import re

def findSmiles(sequene: str) -> str: 
    pattern = r"]<\)"
    smiles_count = re.findall(pattern,sequene)
    return "Количество смайликов: " +  str(len(smiles_count))


sequene1 = "]<)"
sequene2 = "]<)_]<) "
sequene3 = "]];';12;:]<>]<)"
sequene4 = "]<) этот смайлик обозначает ]<)"
sequene5 = "] < )"

print(findSmiles(sequene1))
print(findSmiles(sequene2))
print(findSmiles(sequene3))
print(findSmiles(sequene4))
print(findSmiles(sequene5))






