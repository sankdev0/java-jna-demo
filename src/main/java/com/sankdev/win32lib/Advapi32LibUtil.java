package com.sankdev.win32lib;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.ptr.IntByReference;

/**
 * Utility class offers methods mapped to win32 api advapi32 library.
 * Makes use of {@link com.sankdev.win32lib.Advapi32Lib}.
 * <b>Better implementation can be found in jna-platform
 * win32 package.</b>
 */
public class Advapi32LibUtil {

    /**
     * Retrieves the name of the user associated with the current thread.
     *
     * @return A user name.
     */
    public static String getUserName() {
        char[] buffer = new char[128];
        IntByReference len = new IntByReference(buffer.length);
        boolean result = Advapi32.INSTANCE.GetUserNameW(buffer, len);

        if (!result) {
            throw new RuntimeException("Failed to retrieve the user name " +
                    "via win32 api");
        }

        return Native.toString(buffer);
    }
}
