# CS5351-Group10

group memebers:

Yiming  Sun 		56878409

Chenhao Zhang		56654309

Wenhao Xia			56817115

Wei Zhao			56796569

Lei Zhang			56730372

Zihao Wei			54774508



**=============================================**

function introduntion

this plugin mainly has 3 main function:
1. Automic Chinese punctuation translation
  
  when the system input method is Chinese, the editor can still show the punctuation in English.

2. Automic color RGB translation

  when you need to input a color RGB code, such as #000000(BLACK), you can input the "#", then input the color name, then press "space"
  
  for example:
    
  **#red   -->  #FF0000**
  
3. Automic annotation translation

  when you need to input any English annotations, you can input "#" first, then input the content in Chinese, finally press the "space"
  
  **#这是一个函数  -->  #this is a function **
  
  
  
Extra function: personalization setting

  you can click "file--> setting" to check the setting, main functions include:
  1. set the matching rule of punctuation translation and color RGB translation
  2. click the "reset" button to go back to the initial status

**=============================================
**


install step
this prject is a plugin of the IDEA, there are two running appoarches for this preject.

Method 1:
1. you can directly import the ch-help.jar file into your IDEA
2. restart your IDEA
3. then you can use the functions when you are coding

However, since we did not do the IDEA version compatible，we can not make sure that all the version of IDEA can use our plugin.
If you meet any question about IDEA version compatiabe, you can test the  approach 2

Method 2:
1. import the whole project into your IDEA as a project.
2. decompress the file "intellij-community-master.zip"
3. after building, click file --> project structure --> SDK
4. click "+" at the left-up corner, select "Add IntelliJ Platform plugin SDK"
5. select the file decompress in the step 2
6. select the Java 11(ensure your computer has java 11 SDK)
7. then select the item we create before and click "apply"
8. the build the project again
9. after all the processes have finished
10. click the "run" to open a new runnnig environment IDEA
11. new you can test our function.
