/*
 * Units of Measurement Reference Implementation
 * Copyright (c) 2005-2017, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tec.units.ri.function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import javax.measure.Quantity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

public class PiMultiplierConverterTest {

  private PiMultiplierConverter piMultiplierConverter;

  @Before
  public void setUp() throws Exception {
    piMultiplierConverter = new PiMultiplierConverter();
  }

  @Test
  public void testConvertMethod() {
    Assert.assertEquals(314.15, piMultiplierConverter.convert(100), 0.1);
    Assert.assertEquals(0, piMultiplierConverter.convert(0), 0.0);
    Assert.assertEquals(-314.15, piMultiplierConverter.convert(-100), 0.1);
  }

  @Test
  public void testEqualityOfTwoLogConverter() {
    assertTrue(!piMultiplierConverter.equals(null));
  }

  @Test
  public void testGetValuePiDivisorConverter() {
    assertEquals("(π)", piMultiplierConverter.getValue());
  }

  @Test
  public void isLinearOfLogConverterTest() {
    assertTrue(piMultiplierConverter.isLinear());
  }

  // @Test
  // public void testAngleConverter() {
  // Quantity sut = Quantities.getQuantity(BigDecimal.ONE, Units.DEGREE_ANGLE ).to( Units.RADIAN );
  // assertNotNull(sut);
  // }
}
