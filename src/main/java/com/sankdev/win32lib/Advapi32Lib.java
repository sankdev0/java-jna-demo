package com.sankdev.win32lib;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/**
 * JNA mapping interface that mirrors win32 api advapi32 functions.
 * Extends {@link com.sun.jna.win32.StdCallLibrary} because advapi32.dll
 * uses the __stdcall calling convention
 */
public interface Advapi32Lib extends StdCallLibrary {

    Advapi32Lib advapi32Lib = Native.load(
            "Advapi32", Advapi32Lib.class, W32APIOptions.UNICODE_OPTIONS);

    /**
     * Извлекает имя пользователя, связанного с текущим потоком.
     * http://msdn.microsoft.com/en-us/library/ms724432(VS.85).aspx
     *
     * @param buffer
     *            Буфер для получения имени пользователя для входа в
     *            систему.
     * @param len
     *            На входе - размер буфера, на выходе - количество
     *            символов, скопированных в буфер, включая завершающий нулевой символ.
     * @return Верно, если получилось.
     */
    boolean GetUserNameW(char[] buffer, IntByReference len);
}
