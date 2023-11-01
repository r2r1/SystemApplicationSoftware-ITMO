"""
Написать регулярное выражение, которое проверяет корректность email
и в качестве ответа выдаёт почтовый сервер (почтовый сервер – часть email идущая после «@»).
Для простоты будем считать, что почтовый адрес может содержать в себе буквы, цифры, «.» и «_»,
а почтовый сервер только буквы и «.». При этом почтовый сервер, обязательно должен содержать верхний уровень домена («.ru», «.com», etc.)
"""
import re
     
def findGoodWord(sequene: str) -> str: 
    try:
        pattern = r"[a-zA-Zа-яА-Я\d._]+@[\w]+\.[a-zA-Za-яА-Я]{2,}"
        match = re.findall(pattern, sequene)
        dogIndex = len(match[0])-match[0][::-1].find("@")-1
        postServe = match[0][dogIndex+1:]
        return postServe 
    except:
        return "FAAAAAAAAAAAAIL!!!!!!!!!!!!!!"


sequene1 = "students.spam@ya.ru@ndex.ru"
sequene2 = "example@_.ru"
sequene3 = "example@examp.le.com"
sequene4 = "f@почта.рф"

print(findGoodWord(sequene1))
print(findGoodWord(sequene2))
print(findGoodWord(sequene3))
print(findGoodWord(sequene4))

