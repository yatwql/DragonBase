/**
* COPYRIGHT. THE HSBC Holding LIMITED 2011. ALL RIGHTS RESERVED.
*
* This software is only to be used for the purpose for which it has been
* provided. No part of it is to be reproduced, disassembled, transmitted,
* stored in a retrieval system nor translated in any human or computer
* language in any way or for any other purposes whatsoever without the
* prior written consent of the Hang Seng Bank Limited. Infringement of
* copyright is a serious civil and criminal offence, which can result
* in heavy fines and payment of substantial damages.
*/
package org.roman;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * =========================================================================================
 *
 * Class name       : RomanSuite.java
 *
 * Copyright Notice : COPYRIGHT (C) 2011 BY HSBC
 *
 * Amendment History:
 *
 * Date       By            Description
 * ---------- ------------- ----------------------------------------------------
 * Aug 2, 2011    34029383
 *
 * =========================================================================================
 **/

/**
 * @author 34029383
 *
 */
@RunWith(Suite.class)
@SuiteClasses({RomansNumeralsTest.class,NumeralsRomansTest.class})
public class RomanSuite {

}
