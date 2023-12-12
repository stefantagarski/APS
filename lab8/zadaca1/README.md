You should implement Windows Explorer by using a tree. Nodes are directories/files. Initially you have only one directory c: and it is your current directory. You will be given an array of commands where each command is one of the following:

CREATE [name of directory/file] - you should create new directory/file in the current directory. Be careful when adding new directory/file, it should be put in a position such that all directories/files in the current folder will be sorted lexicographically.

OPEN [name of directory/file] - you open the directory in the current folder and the current folder is changed.

DELETE [name of directory/file] - you delete the folder/file.

BACK - you are back in the previous directory.

PATH - prints the path of the current directory, for example c:\users\darko\mydocuments.

PRINT - prints the whole file system structure such that each directory/file is printed in a new line with spaces equal to level of that directory/file.

Note: The names of the directories/files contain only one word composed of lowercase Latin letters.

Class name: WindowsExplorer

