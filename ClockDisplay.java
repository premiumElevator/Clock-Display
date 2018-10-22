
/**
 * The ClockDisplay class implements a digital clock display 12 hour clock.
 * The clock shows hours and minutes.
 * The range of the clock is 00:00 (midnight) to 12:59 (one minute before
 * 1PM).
 *
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 *
 * @author Peter Basily
 * @version 2018.09.30
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private boolean isPM;
    private String displayString;    // simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        isPM = false;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the
     * parameters.
     */
    public ClockDisplay(int hour, int minute, boolean isPM)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        this.isPM = isPM;
        setTime(hour, minute, isPM);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */

    public void toggle()
    {
      this.isPM = !isPM;
    }
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0)
        {  // it just rolled over!
            hours.increment();

         if(hours.getValue() == 12)
         toggle();

        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, boolean isPM)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        this.isPM = isPM;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {

      if(isPM)
      {
        if(hours.getValue()==0)
        {
            displayString = "1:" + minutes.getDisplayValue() + " PM";
        }
        else
        {
            displayString = hours.getDisplayValue() + ":" +
                        minutes.getDisplayValue() + " PM";
        }
      }
      else
      {
        if(hours.getValue()==0)
        {
            displayString = "12:" + minutes.getDisplayValue() + " AM";
        }
        else
        {
            displayString = hours.getDisplayValue() + ":" +
                         minutes.getDisplayValue() + " AM";
        }
      }
    }
}
