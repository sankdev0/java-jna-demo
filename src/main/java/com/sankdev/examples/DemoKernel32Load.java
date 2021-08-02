package com.sankdev.examples;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;

public class DemoKernel32Load {

  // kernel32.dll uses the __stdcall calling convention (check the function
  // declaration for "WINAPI" or "PASCAL"), so extend StdCallLibrary
  // Most C libraries will just extend com.sun.jna.Library.
  public interface Kernel32 extends StdCallLibrary {
    // Method declarations,constant and structure definitions go here.

    // define an instance of the native library using the
    // Native.load(Class) method, providing the native library interface
    // you defined previously.
    // The INSTANCE variable is for convenient reuse of a single
    // instance of the library. Alternatively, you can load the
    // library into a local variable so that it will be available
    // for garbage collection when it goes out of scope. A Map of
    // options may be provided as the third argument to load to
    // customize the library behavior.
    Kernel32 INSTANCE = (Kernel32) Native.load("kernel32", Kernel32.class);

    // Optional: wraps every call to the native library in a
    // synchronized block, limiting native calls to one at a time.
    Kernel32 SYNC_INSTANCE = (Kernel32) Native.synchronizedLibrary(INSTANCE);

    // Declare methods that mirror the functions in the target
    // library by defining Java methods with the same name and
    // argument types as the native function. You may also need
    // to declare native structures to pass to your native functions.
    // To do this, create a class within the interface definition
    // that extends Structure and add public fields (which may
    // include arrays or nested structures).

    @Structure.FieldOrder({"wYear", "wMonth", "wDayOfWeek", "wDay", "wHour", "wMinute", "wSecond",
        "wMilliseconds"})
    class SYSTEMTIME extends Structure {

      public short wYear;
      public short wMonth;
      public short wDayOfWeek;
      public short wDay;
      public short wHour;
      public short wMinute;
      public short wSecond;
      public short wMilliseconds;
    }

    void GetSystemTime(SYSTEMTIME result);

  }


  // You can now invoke methods on the library instance just like any other Java class.
  public static void main(String[] args) {

    Kernel32 lib = Kernel32.INSTANCE;

    Kernel32.SYSTEMTIME time = new Kernel32.SYSTEMTIME();
    lib.GetSystemTime(time);

    System.out.println("Today's integer value is " + time.wDay);
  }
}
