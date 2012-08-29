/*
 * Copyright (c) 2008 Massimiliano Ziccardi Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package it.jnrpe;


/**
 * Enumeration of all the supported status.
 *
 * @author Massimiliano Ziccardi
 */
public enum Status
{
    /**
     * Service status 'OK'.
     */
    OK(0),
    /**
     * Service status 'WARNING'.
     */
    WARNING(1),
    /**
     * Service status 'CRITICAL'.
     */
    CRITICAL(2),
    /**
     * Service status 'UNKNOWN'.
     */
    UNKNOWN(3);

    /**
     * The enumeration int value.
     */
    private final int m_iIntValue;

    /**
     * Builds an enumeration with the given int value.
     * @param iValue The value
     */
    Status(final int iValue)
    {
        m_iIntValue = iValue;
    }

    /**
     * Returns the int value of the enum.
     * @return The int value
     */
    public int intValue()
    {
        return m_iIntValue;
    }

    /**
     * Returns the enum corresponding with the given int value.
     * @param iIntValue The int value to be converted
     * @return A {@link Status} enum. Null if not found
     */
    public static Status fromIntValue(final int iIntValue)
    {
        switch (iIntValue)
        {
            case 0:
                return OK;
            case 1:
                return WARNING;
            case 2:
                return CRITICAL;
            case 3:
                return UNKNOWN;
            default:
                return OK;
        }
    }
}
