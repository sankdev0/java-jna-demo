package com.sankdev.win32lib;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.ptr.IntByReference;

/**
 * Utility class offers methods mapped to win32 api kernel32 library.
 * Makes use of {@link com.sankdev.win32lib.Kernel32Lib}.
 * <b>Better implementation can be found in jna-platform
 * win32 package.</b>
 */
public class Kernel32LibUtil {

    public static String getComputerName() {
        char[] lpBuffer = new char[WinBase.MAX_COMPUTERNAME_LENGTH + 1];
        IntByReference nSize = new IntByReference(lpBuffer.length);

        if (!Kernel32Lib.INSTANCE.GetComputerName(lpBuffer, nSize)){
            throw new RuntimeException("Failed to retrieve the computer " +
                    "name using win32 api");
        }

        return Native.toString(lpBuffer);
    }
}
