Scenario:  Transfer from Romans

Given a new converter
When set the romans as (I)
Then the decimal value should look like (1)

Given a new converter
When set the romans as (V)
Then the decimal value should look like (5)

When set the romans as (I)
Then the decimal value should look like (1)

When set the romans as (X)
Then the decimal value should look like (10)

When set the romans as (L)
Then the decimal value should look like (50)

When set the romans as (C)
Then the decimal value should look like (100)

When set the romans as (D)
Then the decimal value should look like (500)

When set the romans as (M)
Then the decimal value should look like (1000)

When set the romans as (CDXLVIII)
Then the decimal value should look like (448)

When set the romans as (MCMXLIV)
Then the decimal value should look like (1944)

When set the romans as (MMVIII)
Then the decimal value should look like (2008)

When set the romans as (mmxii)
Then the decimal value should look like (2012)

When set the romans as (MMDCCLI)
Then the decimal value should look like (2751)