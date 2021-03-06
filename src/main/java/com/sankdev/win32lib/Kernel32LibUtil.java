package com.sankdev.win32lib;

import com.sankdev.win32lib.Kernel32Lib._OSVERSIONINFO;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.ptr.IntByReference;

/**
 * Utility class offers methods mapped to win32 api kernel32 library. Makes use of {@link
 * com.sankdev.win32lib.Kernel32Lib}.
 * <b>Better implementation can be found in jna-platform
 * win32 package.</b>
 */
public class Kernel32LibUtil {

  public static String getComputerName() {
    char[] lpBuffer = new char[WinBase.MAX_COMPUTERNAME_LENGTH + 1];
    IntByReference nSize = new IntByReference(lpBuffer.length);

    if (!Kernel32Lib.INSTANCE.GetComputerName(lpBuffer, nSize)) {
      throw new RuntimeException("Failed to retrieve the computer name using win32 api");
    }

    return Native.toString(lpBuffer);
  }

  public static String getWindowsDirectory() {
    char[] lpBuffer = new char[WinBase.MAX_PATH];
    int uSize = lpBuffer.length;

    if (Kernel32Lib.INSTANCE.GetWindowsDirectoryW(lpBuffer, uSize) == 0) {
      throw new RuntimeException(
          "Failed to retrieve the path of the Windows directory using win32 api");
    }

    return Native.toString(lpBuffer);
  }

  public static String getSystemDirectory() {
    char[] lpBuffer = new char[WinBase.MAX_PATH];
    int uSize = lpBuffer.length;

    if (Kernel32Lib.INSTANCE.GetSystemDirectoryW(lpBuffer, uSize) == 0) {
      throw new RuntimeException("Failed to retrieve the path of the system directory using win32"
          + " api");
    }

    return Native.toString(lpBuffer);
  }

  public static String getTempPath() {
    char[] lpBuffer = new char[WinBase.MAX_PATH];
    int nBufferLength = lpBuffer.length;

    if (Kernel32Lib.INSTANCE.GetTempPathW(nBufferLength, lpBuffer) == 0) {
      throw new RuntimeException("Failed to retrieve the path of the directory designated for"
          + "temporary files using win32 api");
    }

    return Native.toString(lpBuffer);
  }

  public static String getVersionInfo() {

    Kernel32Lib._OSVERSIONINFO OSVERSIONINFO = new _OSVERSIONINFO();
    OSVERSIONINFO.szCSDVersion = new char[128];
    OSVERSIONINFO.dwOSVersionInfoSize = OSVERSIONINFO.size();

    if (!Kernel32Lib.INSTANCE.GetVersionEx(OSVERSIONINFO)) {
      throw new RuntimeException("Failed to retrieve extended OS version info using win32 api");
    }

    return "major version number - " + OSVERSIONINFO.dwMajorVersion + "; minor version number - "
        + OSVERSIONINFO.dwMinorVersion + "; build number - " + OSVERSIONINFO.dwBuildNumber
        + "; operating system platform - " + OSVERSIONINFO.dwPlatformId + "; latest Service Pack "
        + "installed - " + Native.toString(OSVERSIONINFO.szCSDVersion);
  }
}
