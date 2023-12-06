# Вариант 5 

"""
С помощью регулярного выражения найти в тексте все слова, в которых две гласные стоят подряд, 
а после этого слова идёт слово, в котором не больше 3 согласных.
"""
import re

def findGoodWord(sequene: str) -> str: 
    sequene = sequene.replace("-","")
    try:
        pattern = r"\b\w*[аяуюоеёэиы]{2}\w*\b[,\- ]+\b([аеёиоуыэюя]*[бвгджзйклмнпрстфхцчшщ]){1,3}[аеёиоуыэюя]*\b"
        match = re.search(pattern, sequene).group()
        goodWord = str(match.split()[0])
        return goodWord if goodWord[-1] != "," else goodWord[:-1]
    except:
        return "Введите норм фразу!!! Эта не подходит :("

sequene1 = " ое нг-нгш, о е прпр, оп"
sequene2 = "сотка по лабе - военник в канаве"
sequene3 = "дуетом пели песни"
sequene4 = "я помню белые обои..."
sequene5 = "Степан_Дмитриевич, можно соточку?)"


print(findGoodWord(sequene1))
print(findGoodWord(sequene2))
print(findGoodWord(sequene3))
print(findGoodWord(sequene4))
print(findGoodWord(sequene5))


