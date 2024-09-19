import com.example.state.AppContext;

public class StateTest {

    public static void main(String[] args) {
        AppContext context = new AppContext();
        context.forward();
        context.collect();
        context.comment("说的太好了，双手双脚给个赞👍");
    }
}
