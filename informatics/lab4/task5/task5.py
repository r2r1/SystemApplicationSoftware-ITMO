import time


start_time_file1 = time.time()
exec(open('informatics/lab4/task1/task1.py').read())
end_time_file1 = time.time()
execution_time_file1 = end_time_file1 - start_time_file1
print("Время выполнения задания 1:     ", execution_time_file1 * 100, "seconds")


start_time_file2 = time.time()
exec(open('informatics/lab4/task2/task2.py').read())
end_time_file2 = time.time()
execution_time_file2 = end_time_file2 - start_time_file2
print("Время выполнения доп. задания 1:", execution_time_file2 * 100, "seconds")

start_time_file3 = time.time()
exec(open('informatics/lab4/task3/task3.py').read())
end_time_file3 = time.time()
execution_time_file3 = end_time_file3 - start_time_file3
print("Время выполнения доп. задания 2:", execution_time_file3 * 100, "seconds")

start_time_file4 = time.time()
exec(open('informatics/lab4/task4/task4.py').read())
end_time_file4 = time.time()
execution_time_file4 = end_time_file4 - start_time_file4
print("Время выполнения доп. задания 3:", execution_time_file4 * 100, "seconds")