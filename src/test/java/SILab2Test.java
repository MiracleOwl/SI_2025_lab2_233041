import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryStatement() {

        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
            SILab2.checkCart(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex1.getMessage());


        Item item2 = new Item(null, 1, 100, 0);
        RuntimeException ex2 = assertThrows(RuntimeException.class, () ->
            SILab2.checkCart(List.of(item2), "1234567890123456"));
        assertEquals("Invalid item!", ex2.getMessage());


        Item item3 = new Item("Book", 1, 100, 0);
        double result3 = SILab2.checkCart(List.of(item3), "1234567890123456");
        assertEquals(100.0, result3);


        Item item4 = new Item("Pen", 2, 50, 0.2);
        double result4 = SILab2.checkCart(List.of(item4), "1234567890123456");
        assertEquals(80.0, result4); // 50 * 0.8 * 2 = 80


        Item item5 = new Item("Laptop", 1, 350, 0);
        double result5 = SILab2.checkCart(List.of(item5), "1234567890123456");
        assertEquals(320.0, result5); // 350 - 30 penalty


        Item item6 = new Item("Mouse", 1, 50, 0);
        RuntimeException ex6 = assertThrows(RuntimeException.class, () ->
            SILab2.checkCart(List.of(item6), "12345"));
        assertEquals("Invalid card number!", ex6.getMessage());


        RuntimeException ex7 = assertThrows(RuntimeException.class, () ->
            SILab2.checkCart(List.of(item6), "1234abcd12345678"));
        assertEquals("Invalid character in card number!", ex7.getMessage());


        Item item8 = new Item("Bulk", 15, 10, 0);
        double result8 = SILab2.checkCart(List.of(item8), "1234567890123456");
        assertEquals(120.0, result8); // (10*15)-30
    }

    @Test
    void testMultipleCondition() {
        String validCard = "1234567890123456";


        Item aTrue = new Item("A", 1, 301, 0);
        double resA = SILab2.checkCart(List.of(aTrue), validCard);
        assertEquals(271.0, resA); // penalty

        Item bTrue = new Item("B", 1, 100, 0.1);
        double resB = SILab2.checkCart(List.of(bTrue), validCard);
        assertEquals(60.0, resB); // 100 * 0.9 = 90 - 30 penalty = 60

        Item cTrue = new Item("C", 11, 10, 0);
        double resC = SILab2.checkCart(List.of(cTrue), validCard);
        assertEquals(80.0, resC); // 110 - 30 penalty

        Item allTrue = new Item("All", 20, 400, 0.5);
        double resAll = SILab2.checkCart(List.of(allTrue), validCard);
        assertEquals(3970.0, resAll); // (400*0.5*20) = 4000 - 30 = 3970

        Item at_cf = new Item("A-C", 11, 400, 0);
        double resAC = SILab2.checkCart(List.of(at_cf), validCard);
        assertEquals(4370.0, resAC); // (400*11)-30

        double resBC = SILab2.checkCart(List.of(bt_ct), validCard);
        assertEquals(1320.0, resBC); // 100*0.9*15 = 1350 - 30

        Item at_bt = new Item("A-B", 1, 400, 0.2);
        double resAB = SILab2.checkCart(List.of(at_bt), validCard);
        assertEquals(290.0, resAB); // 400*0.8 = 320 - 30 = 290

        Item none = new Item("None", 1, 100, 0);
        double resNone = SILab2.checkCart(List.of(none), validCard);
        assertEquals(100.0, resNone); // no penalty
    }
}
