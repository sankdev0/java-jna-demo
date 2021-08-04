package com.sankdev.sysinfo;

import com.sankdev.win32lib.Advapi32LibUtil;
import com.sankdev.win32lib.Kernel32LibUtil;
import com.sankdev.win32lib.User32LibUtil;

public class SysInfoProgram {

  public static void main(String[] args) {

    System.out.println("Имя компьютера: " + Kernel32LibUtil.getComputerName());

    System.out.println("Имя пользователя для текущего потока: " + Advapi32LibUtil.getUserName());

    System.out.println("Путь к каталогу Windows: " + Kernel32LibUtil.getWindowsDirectory());

    System.out.println("Путь к системному каталогу: " + Kernel32LibUtil.getSystemDirectory());

    System.out.println("Путь к каталогу временных файлов: " + Kernel32LibUtil.getTempPath());

    System.out.println("Информация о версии ОС: " + Kernel32LibUtil.getVersionInfo());

    System.out.println();

    User32LibUtil.printSystemMetrics();
  }
}
