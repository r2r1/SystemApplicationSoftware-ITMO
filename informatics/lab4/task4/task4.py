json_file =  open("informatics/lab4/task4/task4.json", 'r', encoding="utf-8") 

first_line = False
flagNewBlock = False
content = "---\n"
check_tab= 0

for line in json_file:
    for c in "\'\"[]":
            line = line.replace(c, '')
    if ":{" in line :
        line = line.replace(":{" , ': {')
    if "," in line :
        line = line.replace("," , ' ') 
        
    new_line = ""
    components = line.split()
    
    if components != []:  
        if components[0] == '{' : 
            check_tab += 1 
            flagNewBlock = True 
            
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
                            new_line += ("\t"*(check_tab-1)) + components[i]
                            flagNewBlock = False
                        elif  not components[0] == '}' :
                            new_line += ("\t"*(check_tab-1))+ components[i]
                        
                        if "{" in new_line:
                            new_line =  new_line.replace("}", "\n")
        else:   
            key = components[0] 
            value = ' '.join(components[1:])  
            if "{" not in components[0]:
                if (check_tab > 0) and (flagNewBlock == True) and not components[0] == '}' and ( (components[0] not in "}" ) and len(components) == 1) :
                    new_line +=  ("\t"*check_tab)+ key + " " + value + "\n"
                    flagNewBlock = False 
                elif  not components[0] == '}' :
                    new_line += ("\t"*check_tab) +  key + " " + value  + "\n"
                if "{" in new_line:
                    new_line =  new_line.replace("{", "\n")
        if components[0] == '}':
            check_tab -= 1  
        if new_line != "":
            content += new_line 
with open("informatics/lab4/task4/task_4.yaml", 'w', encoding="utf-8") as f_out:
   f_out.write(content)