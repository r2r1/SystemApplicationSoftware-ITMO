json_file =  open("informatics/lab4/data/data.json", 'r', encoding="utf-8") 

first_line = False
flagNewBlock = False
content = "---\n"
check_tab= 0

# пройдемся по каждой строки нашего json 
for line in json_file:
    # убрать ненужные символы
    for c in "\'\",[]":
        line = line.replace(c, '')
    if ":{" in line :
        line = line.replace(":{" , ': {')
    if "," in line :
        line = line.replace("," , ' ') 
    if "{" in line :
        line = line.replace("{" , ' { ')      
        
    # создать строку, которая будет записывать всё в переменную content
    new_line = ""
    # разделить строку на компоненты
    components = line.split()
    
    if components != []:  # проверка на пустотые массивы, они не должны быть 
        # проверка на новый блок, тут мы ничего записывать не будем, а только запоминать, что сейчас мы в новом блоке 
        if components[0] == '{': # Символ -"{" в Json обозначает новый блок, нам это необходимо знать, чтобы создавать свои новые блоки в Yaml
            check_tab += 1 # каждый новый блок - + tab, а это счетчик табов
            flagNewBlock = True # этот флаг нужен, чтобы отслеживать новые блоки и контролировать табуляцию 
        if components.count("{") > 1 or components.count(":") > 1:
            for i in  range(1, len(components)):
                    if "{" == components[i]:
                        check_tab +=1
                        flagNewBlock == True                        
                    else: 
                        if (":" ==  components[i][-1]) and (":" !=  components[i+1][-1]) and ("{" not in components[i+1]):
                            components[i+1] += "\n"
                        elif ":" !=  components[i][-1] and ":" ==  components[i-1][-1] :
                            True
                        else:
                            components[i] += "\n"
                            
                        if ("{" not in components[i])  and (flagNewBlock == True):
                            new_line += ("\t"*(check_tab)) + components[i]
                            flagNewBlock = False
                            
                        elif  not components[0] == '}' :
                            new_line += ("\t"*(check_tab))+ components[i]
                        elif ("{" not in components[i])  and (flagNewBlock == False):
                            new_line += ("\t"*(check_tab)) + components[i]
                        if "{" in new_line:
                            new_line =  new_line.replace("}", "\n")
                        print(new_line)  
        # если же блок не новый, то табуляция остается с прошлой строки, для этого мы запоминали
        else:   
            key = components[0] # ключ 
            value = ' '.join(components[1:])  # значение ключа 
            if "{" not in components[0]:   
                # если табов больше нуля и нынешняя строка, которая не равна "}" (т.к. это вспомогательный символ) создает новый "супер-ключ", в котором только одно слово (lesson№)
                if (check_tab > 0) and (flagNewBlock == True) and not components[0] == '}' and ( (components[0] not in "}" ) and len(components) == 1) :
                    new_line += "-"+ ("\t"*check_tab) + key + " " + value + "\n" # сама строка, где табуляция = кол-ву блоков 
                    flagNewBlock = False # флаг становится ложным, потому что мы уже сделали нужные отступы, чтобы обозначить новый блок 
                     
                elif  not components[0] == '}' :
                    new_line += ("\t"*check_tab) +  key + " " + value  + "\n" # если же строка не начало нового блока, то в нее записываем компонент 
                if "{" in new_line:
                    new_line =  new_line.replace("{", "\n")
        # если нам встретится символ, закрывающий блок, то табуляция надо откатить (если этого не сделать, то она будет только возрастать) 
        if components[0] == '}':
            check_tab -= 1  
             
         # добавляем в content всё без пустых строк       
        if new_line != "":
            content += new_line 
            
#записать content в yaml 
with open("informatics/lab4/task1/task_1.yaml", 'w', encoding="utf-8") as f_out:
   f_out.write(content)