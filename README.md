# SI_2025_lab2_233041
Valentino
Cvetanovski
233041
3. 
  Ciklomatska kompleksnost e 8, so formula M = broj na uslovi + 1
  ima 7 if+logicki granki + 1 = 8
4.
  Invalid character in card number!
  allItems == null
  item.getName() == null
  item.getPrice() > 300
  item.getDiscount() > 0
  item.getQuantity() > 10
  Invalid card number!
  cardNumber == null
Minimum treba 8 testovi
5. 
Imame 3 uslovi:
  A: item.getPrice() > 300
  B: item.getDiscount() > 0
  C: item.getQuantity() > 10
Test primer za site:
  A=F, B=F, C=F → Item(100, 1, 0)
  A=F, B=F, C=T → Item(100, 11, 0)
  A=F, B=T, C=F → Item(100, 1, 0.1)
  A=F, B=T, C=T → Item(100, 11, 0.1)
  A=T, B=F, C=F → Item(400, 1, 0)
  A=T, B=F, C=T → Item(400, 11, 0)
  A=T, B=T, C=F → Item(400, 1, 0.1)
  A=T, B=T, C=T → Item(400, 11, 0.1)
Minimalni slucai treba 8 da ima!
