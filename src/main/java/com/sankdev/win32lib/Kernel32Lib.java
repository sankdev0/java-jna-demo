package com.sankdev.win32lib;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/**
 * JNA mapping interface that mirrors win32 api kernel32 functions. Extends {@link
 * com.sun.jna.win32.StdCallLibrary} because kernel32.dll uses the __stdcall calling convention
 */
public interface Kernel32Lib extends StdCallLibrary {

  // define an instance of the native library
  Kernel32Lib INSTANCE = Native.load("kernel32", Kernel32Lib.class,
      W32APIOptions.UNICODE_OPTIONS);

  // define methods that mirror the functions in the target library

  /**
   * Получает NetBIOS имя локального компьютера в буфер lpBuffer.
   *
   * @param lpBuffer Указатель на буфер, который получает имя компьютера или имя виртуального
   *                 сервера кластера. Размер буфера должен быть достаточно большим, чтобы содержать
   *                 MAX_COMPUTERNAME_LENGTH + 1 символов.
   * @param nSize    При вводе указывает размер буфера в TCHAR. На выходе количество TCHAR,
   *                 скопированных в целевой буфер, не включая завершающий нулевой символ. Если
   *                 буфер слишком мал, функция завершается ошибкой, и GetLastError возвращает
   *                 ERROR_BUFFER_OVERFLOW. Параметр lpnSize указывает размер необходимого буфера,
   *                 включая завершающий нулевой символ.
   * @return Если функция завершается успешно, возвращаемое значение - ненулевое значение. Если
   * функция не работает, возвращаемое значение равно нулю. Чтобы получить расширенную информацию об
   * ошибке, вызовите GetLastError.
   */
  boolean GetComputerName(
      char[] lpBuffer, // char[] maps to LPSTR
      IntByReference nSize // IntByReference maps to LPDWORD
  );

  /**
   * Получет путь к каталогу Windows компьютера в буфер lpBuffer. Каталог Windows - это каталог, в
   * котором некоторые устаревшие приложения хранят файлы инициализации и справки. Чаще всего, это
   * папка Windows на системном диске.
   * @param lpBuffer Указатель на буфер, в который будет получен путь.
   * @param uSize Максимальный размер буфера в TCHAR. Должно быть указано MAX_PATH.
   * @return Если функция завершается успешно, возвращаемое значение - количество записанных в буфер
   * символов в TCAHR, не включая завершающий нулевой символ. В случае сбоя возвращаемое значение
   * равно нулю. Чтобы получить расширенную информацию об ошибке, вызовите GetLastError.
   */
  int GetWindowsDirectoryW(
      char[] lpBuffer,
      int uSize
  );

  /**
   * Получет путь к системному компьютера в буфер lpBuffer. Системный каталог содержит системные
   * файлы, такие как библиотеки динамической компоновки и драйверы.
   * @param lpBuffer Указатель на буфер для получения пути. Этот путь не заканчивается обратной
   *                 косой чертой, если системный каталог не является корневым. Например, если
   *                 системный каталог называется Windows \ System32 на диске C, путь к системному
   *                 каталогу, полученному этой функцией, будет C: \ Windows \ System32.
   * @param uSize Максимальный размер буфера в TCHAR.
   * @return Если функция завершается успешно, возвращаемое значение - это длина строки,
   * скопированной в буфер, в TCHAR, не включая завершающий нулевой символ. В случае сбоя
   * возвращаемое значение равно нулю. Чтобы получить расширенную информацию об ошибке, вызовите
   * GetLastError.
   */
  int GetSystemDirectoryW(
      char[] lpBuffer,
      int uSize
  );


  /**
   * Получает путь к каталогу, предназначенному для временных файлов.
   * @param nBufferLength Размер строкового буфера, идентифицированного lpBuffer, в TCHAR.
   * @param lpBuffer Указатель на строковый буфер, который принимает строку с завершающим нулем,
   *                 определяющую путь к временному файлу. Возвращаемая строка заканчивается
   *                 обратной косой чертой, например, «C: \ TEMP \».
   * @return Если функция завершается успешно, возвращаемое значение представляет собой длину в
   * TCHAR строки, скопированной в lpBuffer, не включая завершающий нулевой символ. Если
   * возвращаемое значение больше nBufferLength, возвращаемое значение - это длина в TCHAR буфера,
   * необходимого для хранения пути.
   * Если функция не работает, возвращаемое значение равно нулю. Чтобы получить расширенную
   * информацию об ошибке, вызовите GetLastError.
   * Максимально возможное возвращаемое значение - MAX_PATH + 1 (261).
   */
  int GetTempPathW(
      int  nBufferLength,
      char[] lpBuffer
  );
}
