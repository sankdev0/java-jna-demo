package com.sankdev.win32lib;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/**
 * JNA mapping interface that mirrors win32 api kernel32 functions.
 * Extends {@link com.sun.jna.win32.StdCallLibrary} because kernel32.dll
 * uses the __stdcall calling convention
 */
public interface Kernel32Lib extends StdCallLibrary{

    // define an instance of the native library
    Kernel32Lib INSTANCE = Native.load("kernel32", Kernel32Lib.class,
            W32APIOptions.UNICODE_OPTIONS);

    // define methods that mirror the functions in the target library

    /**
     * Возвращает NetBIOS имя локального компьютера.
     *
     * @param lpBuffer
     *            Указатель на буфер, который получает имя компьютера
     *            или имя виртуального сервера кластера. Размер буфера
     *            должен быть достаточно большим, чтобы содержать
     *            MAX_COMPUTERNAME_LENGTH + 1 символов.
     * @param nSize
     *            При вводе указывает размер буфера в TCHAR. На выходе
     *            количество TCHAR, скопированных в целевой буфер, не
     *            включая завершающий нулевой символ. Если буфер слишком
     *            мал, функция завершается ошибкой, и GetLastError
     *            возвращает ERROR_BUFFER_OVERFLOW. Параметр lpnSize
     *            указывает размер необходимого буфера, включая
     *            завершающий нулевой символ.
     * @return Если функция завершается успешно, возвращаемое значение
     * - ненулевое значение. Если функция не работает, возвращаемое
     * значение равно нулю. Чтобы получить расширенную информацию об
     * ошибке, вызовите GetLastError.
     */
    boolean GetComputerName(
            char[] lpBuffer, // char[] maps to LPSTR
            IntByReference nSize // IntByReference maps to LPDWORD
    );
}
