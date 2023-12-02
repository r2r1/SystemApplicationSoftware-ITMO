import re

json_file =  open("informatics/lab4/data\data.json", 'r', encoding="utf-8") 

first_line = False
flagNewBlock = False
content = "---\n"
check_tab= 0

for line in json_file:
    line = re.sub(r"[\'\",\[\]]", '', line)
    new_line = ""
    components = line.split()
    
    if components != []:
        if components[0] == '{': 
            check_tab += 1 
            flagNewBlock = True        
        else:   
                key = components[0]
                value = ' '.join(components[1:])  
                if (check_tab > 0) and (flagNewBlock == True) and not components[0] == '}' and ( (components[0] not in "}" ) and len(components) == 1) :
                    new_line += "-"+ ("\t"*check_tab) + key + " " + value + "\n" 
                    flagNewBlock = False 
                elif  not components[0] == '}' :
                    new_line += ("\t"*check_tab) +  key + " " + value  + "\n"
        if components[0] == '}':
            check_tab -= 1  
        if new_line != "":
            content += new_line 
with open("informatics/lab4/task3/task_3.yaml", 'w', encoding="utf-8") as f_out:
   f_out.write(content)