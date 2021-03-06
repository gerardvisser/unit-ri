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
package tec.units.ri.quantity;

import static org.junit.Assert.assertEquals;

import javax.measure.Quantity;
import javax.measure.quantity.ElectricResistance;
import javax.measure.quantity.Length;
import javax.measure.quantity.Time;

import org.junit.Assert;
import org.junit.Test;

import tec.units.ri.AbstractQuantity;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

public class DoubleQuantityTest {

  @Test
  public void divideTest() {
    DoubleQuantity<ElectricResistance> quantity1 = new DoubleQuantity<ElectricResistance>(Double.valueOf(3).doubleValue(), Units.OHM);
    DoubleQuantity<ElectricResistance> quantity2 = new DoubleQuantity<ElectricResistance>(Double.valueOf(2).doubleValue(), Units.OHM);
    Quantity<?> result = quantity1.divide(quantity2);
    assertEquals(Double.valueOf(1.5f), result.getValue());
  }

  @Test
  public void addTest() {
    DoubleQuantity quantity1 = new DoubleQuantity(Double.valueOf(1).doubleValue(), Units.OHM);
    DoubleQuantity quantity2 = new DoubleQuantity(Double.valueOf(2).doubleValue(), Units.OHM);
    Quantity<ElectricResistance> result = quantity1.add(quantity2);
    assertEquals(Double.valueOf(3f), result.getValue());
  }

  @Test
  public void subtractTest() {
    DoubleQuantity<ElectricResistance> quantity1 = new DoubleQuantity<ElectricResistance>(Double.valueOf(1).doubleValue(), Units.OHM);
    DoubleQuantity<ElectricResistance> quantity2 = new DoubleQuantity<ElectricResistance>(Double.valueOf(2).doubleValue(), Units.OHM);
    Quantity<ElectricResistance> result = quantity2.subtract(quantity1);
    assertEquals(Double.valueOf(1), result.getValue());
    assertEquals(Units.OHM, result.getUnit());
  }

  @Test
  public void multiplyQuantityTest() {
    DoubleQuantity<ElectricResistance> quantity1 = new DoubleQuantity<ElectricResistance>(Double.valueOf(3).doubleValue(), Units.OHM);
    DoubleQuantity<ElectricResistance> quantity2 = new DoubleQuantity<ElectricResistance>(Double.valueOf(2).doubleValue(), Units.OHM);
    Quantity<?> result = quantity1.multiply(quantity2);
    assertEquals(Double.valueOf(6L), result.getValue());
  }

  @Test
  public void longValueTest() {
    DoubleQuantity<Time> day = new DoubleQuantity<Time>(Double.valueOf(3).doubleValue(), Units.DAY);
    long hours = day.longValue(Units.HOUR);
    assertEquals(72L, hours);
  }

  @Test
  public void doubleValueTest() {
    DoubleQuantity<Time> day = new DoubleQuantity<Time>(3D, Units.DAY);
    double hours = day.doubleValue(Units.HOUR);
    assertEquals(72D, hours, 0);
  }

  @Test
  public void toTest() {
    Quantity<Time> day = Quantities.getQuantity(1D, Units.DAY);
    Quantity<Time> hour = day.to(Units.HOUR);
    Assert.assertEquals(Double.valueOf(24), hour.getValue());
    Assert.assertEquals(hour.getUnit(), Units.HOUR);

    Quantity<Time> dayResult = hour.to(Units.DAY);
    Assert.assertEquals(dayResult.getValue(), day.getValue());
    Assert.assertEquals(dayResult.getUnit(), day.getUnit());
  }

  @Test
  public void inverseTest() {
    AbstractQuantity<Length> l = NumberQuantity.of(Double.valueOf(10d).doubleValue(), Units.METRE);
    assertEquals(Double.valueOf(1 / 10d), l.inverse().getValue());
  }

  @Test
  public void testEquality() throws Exception {
    Quantity<Length> value = Quantities.getQuantity(10D, Units.METRE);
    Quantity<Length> anotherValue = Quantities.getQuantity(10.00D, Units.METRE);
    Assert.assertEquals(value, anotherValue);
  }

  @Test
  public void testEqualityDifferentPrimitive() throws Exception {
    Quantity<Length> value = Quantities.getQuantity(10, Units.METRE);
    Quantity<Length> anotherValue = Quantities.getQuantity(10.00D, Units.METRE);
    Assert.assertEquals(value, anotherValue);
  }
}
