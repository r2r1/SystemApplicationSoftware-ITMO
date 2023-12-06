
def parseTheObject(str,indent,pointer):
    new_str=""
    c=pointer
    while (str[c]!="}"):
        while(str[c]!="\""):
            if(str[c]=="}"):
                break
            c+=1

        if (str[c]=="}"):
            break
        
        res=parseTheField(str,indent+1,c)
        new_str+="\n"+res[0]
        new_str = new_str.replace("- }", "")
        c=res[1]+1
        
        
    return [new_str,c]

def parseTheField(str,indent,pointer):
    key,value="",""
    c=pointer+1
    while str[c]!="\"":
        key+=str[c]
        c+=1
    c+=1
    while str[c]==" " or str[c]==":":
        c+=1


    if(str[c]=="\""):
        value+="\""
        c+=1
        while(str[c]!="\""):
            value+=str[c]
            c+=1
        c+=1
        value+="\""

    elif (str[c]=="["):
        res=parseTheArray(str,indent,c)
        value="\n"+res[0]
        c=res[1]

    elif(str[c]=="{"):
        res=parseTheObject(str,indent,c)
        value=res[0]
        c=res[1]

    else:
        while(str[c]!=" " and str[c]!="," and str[c]!="}"):
            value+=str[c]
            c+=1
    return ["  "*indent+key+": "+value,c]

def parseTheArray(str,indent,pointer):
    new_str=""
    c=pointer+1
    while (str[c]!="]"):
        while(str[c] in [" ",","," "]):
            if(str[c]=="]"):
                break
            c+=1
            
        if (str[c]=="]"):
            break
        elif (str[c]=="{"):
            res=parseTheObject(str,indent+1,c)
        elif (str[c]=="["):
            res=parseTheArray(str,indent+1,c)
            res[0]="\n"+res[0]
        elif (str[c]=="\""):
            res=["",c+1]
            while(str[res[1]]!="\""):
                res[0]+=str[res[1]]
                res[1]+=1
        else:
            res=["",c]
            while(str[c] not in [" ",",","]"]):
                res[0]+=str[c]
                res[1]+=1
                c+=1
            
        new_str+="  "*indent + "- "+res[0]+"\n"
        c=res[1]
        # print(res)
        # print(c)
        
    return [new_str,c]


f = open("informatics/lab4/task4/task4.json", 'r', encoding="utf-8") 


jsonString=""

for line in f:
    tempLine=line[:-1]
    jsonString+=tempLine

yamlString="---"+parseTheObject(jsonString,-1,0)[0][:-5]


print(yamlString) 
with open("informatics/lab4/task4/task_4.yaml", 'w', encoding="utf-8") as f_out:
   f_out.write(yamlString)