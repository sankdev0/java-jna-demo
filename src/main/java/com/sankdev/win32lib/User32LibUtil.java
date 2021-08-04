package com.sankdev.win32lib;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;

public class User32LibUtil {

  /**
   * Получить метрику SM_ARRANGE.
   *
   * @return Флаги, указывающие, как система упорядочивает свернутые окна. Дополнительные сведения
   * см. В разделе «Примечания» в этом разделе.
   */
  static int getSmArrange() {
    return User32.INSTANCE.GetSystemMetrics(WinUser.SM_ARRANGE);
  }

  /**
   * Получить метрику SM_CLEANBOOT.
   *
   * @return Значение, указывающее, как запускается система: 0 - Нормальная загрузка; 1 -
   * Отказоустойчивая загрузка; 2 - Отказоустойчивость с загрузкой по сети.
   */
  static int getSmCleanBoot() {
    return User32.INSTANCE.GetSystemMetrics(WinUser.SM_CLEANBOOT);
  }

  /**
   * Получить метрику SM_CMONITORS.
   *
   * @return Количество мониторов на рабочем столе. Дополнительные сведения см. В разделе
   * «Примечания» в этом разделе.
   */
  static int getSmMonitors() {
    return User32.INSTANCE.GetSystemMetrics(WinUser.SM_CMONITORS);
  }

  /**
   * Prints some Win System metrics to the Java standard output.
   *
   * @see <a href="https://docs.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-getsystemmetrics">Microsoft
   * Docs</a>
   */
  public static void printSystemMetrics() {
    System.out.println("Some system metrics are given below: ");
    System.out.println("1. SM_ARRANGE: " + getSmArrange());
    System.out.println("2. SM_CLEANBOOT: " + getSmCleanBoot());
    System.out.println("3. SM_CMONITORS: " + getSmMonitors());
    System.out.println("4. SM_CMOUSEBUTTONS: " + User32.INSTANCE.GetSystemMetrics(
        WinUser.SM_CMOUSEBUTTONS)); // The number of buttons on a mouse, or zero if no mouse is installed.
    System.out.println("5. SM_CONVERTIBLESLATEMODE: " + User32.INSTANCE.GetSystemMetrics(
        0x2003)); // Reflects the state of the laptop or slate mode, 0 for Slate Mode and non-zero otherwise.
    System.out.println("6. SM_CXBORDER: " + User32.INSTANCE.GetSystemMetrics(
        WinUser.SM_CXBORDER)); // The width of a window border, in pixels.
    System.out.println("7. SM_CXCURSOR: " + User32.INSTANCE.GetSystemMetrics(
        WinUser.SM_CXCURSOR)); // The width of a cursor, in pixels.
    System.out.println("8. SM_CXDOUBLECLK: " + User32.INSTANCE.GetSystemMetrics(
        WinUser.SM_CXDOUBLECLK)); // The width of the rectangle around the location of a first click in a double-click sequence, in pixels.
    System.out.println("9. SM_CYDOUBLECLK: " + User32.INSTANCE.GetSystemMetrics(
        WinUser.SM_CYDOUBLECLK)); // The height of the rectangle around the location of a first click in a double-click sequence, in pixels.
    // click in a double-click sequence, in pixels.
    System.out.println("10. SM_CXHTHUMB: " + User32.INSTANCE.GetSystemMetrics(
        WinUser.SM_CXHTHUMB)); // The width of the thumb box in a horizontal scroll bar, in pixels.
  }

}
