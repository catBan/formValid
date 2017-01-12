package com.catban.common.demo;

import java.io.File;

/**
 * Created by catban on 16-11-27.
 */
public class RenameFiles {

    public static String[] getFilesName(String path){
        File file = new File(path);
        String[] filesName = file.list();
        return filesName;

    }

    public static boolean renameFiles(String path,String oldname,String newname){
        if(!oldname.equals(newname)){
            File oldnameFile = new File(path+"/"+oldname);
            File newnameFile = new File(path+"/"+newname+oldname.substring(oldname.lastIndexOf(".")));
            if(newnameFile.exists()){
                System.out.println("文件名["+newname+"]已存在，顺次取下一个");
                return false;
            }
            oldnameFile.renameTo(newnameFile);
            System.out.println("重命名:["+oldname+"]-["+newname+"]");
            return true;
        }else {
            System.out.println("文件名与新文件名重合，无需修改");
        }
        return false;

    }

    public static void main(String[] args) {
        String path = "/home/catban/Pictures/New folder";
        String[] fileNames = getFilesName(path);
        int i = 1;
        for (String name:fileNames) {
            boolean flag = renameFiles(path,name, String.valueOf(i));
            System.out.println("original name:"+name);
            while (!flag){
                i = i + 1;
                flag = renameFiles(path,name, String.valueOf(i));
            }
            i = i +1;
        }
    }
}
