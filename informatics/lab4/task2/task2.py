import json
import yaml
#Читаем JSON файл:

with open('informatics/lab4/data\data.json', 'r', encoding='utf8') as f:
    json_data = json.load(f)
#Записываем данные YAML в файл:

with open('informatics/lab4/task2\yaml_2.yaml', 'w', encoding='utf8') as f:
    f.write(yaml.dump(json_data, allow_unicode=True))