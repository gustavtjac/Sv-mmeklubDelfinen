package Members;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @org.junit.jupiter.api.Test
    void membershipFeeShouldBe1000() {
Member victor = new Member("victor",true,14,true);
assertEquals(1000,victor.calculateMembershipFee());

    }
}