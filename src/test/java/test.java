import com.jz.pojo.Order;
import com.jz.service.order.OrderService;
import com.mchange.v1.util.ArrayUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {

    @Autowired
    private OrderService orderService;
    @Test
    public void test(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long nowTime = System.currentTimeMillis();
        String formatNowTime = sdf.format(nowTime);
        System.out.println(formatNowTime);
    }
}
