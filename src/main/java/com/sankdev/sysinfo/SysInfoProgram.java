package com.sankdev.sysinfo;

import com.sankdev.win32lib.Advapi32LibUtil;
import com.sankdev.win32lib.Kernel32Lib;
import com.sankdev.win32lib.Kernel32LibUtil;

public class SysInfoProgram {

  public static void main(String[] args) {

    System.out.println("Имя компьютера: "
        + Kernel32LibUtil.getComputerName());

    System.out.println("Имя пользователя для текущего потока: "
        + Advapi32LibUtil.getUserName());

    System.out.println("Путь к каталогу Windows: " + Kernel32LibUtil.getWindowsDirectoryW());

  }
}
