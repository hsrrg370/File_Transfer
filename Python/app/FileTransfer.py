import os
import os.path
from re import compile
from shutil import move

fileList = os.listdir(os.getcwd())
extentions = open("Extentions.txt","r")
pattern = list(extentions.readline().split(','))
dng_path = os.getcwd+"..\DNG"
jpg_path = os.getcwd+"..\DCIM"
for file in fileList:
    for value in pattern:
        ptr = compile("\."+value+"$")
        if ptr.search(file):
            if value=="DNG":
                new_path = move(os.getcwd+"\\"+f,dng_path)
            elif value=="JPG":
                new_path = move(os.getcwd+"\\"+f,jpg_path)
            break
extentions.close()