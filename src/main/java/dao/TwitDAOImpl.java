package dao;

import domain.Twit;
import domain.User;
import domain.UserSubscribe;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ymolodkov
 * @date 01/01/15.
 * @since 0.1
 */
public class TwitDAOImpl implements TwitDAO {


    Map<Integer, User> users = new HashMap<>();
    Map<Integer, Twit> twits = new HashMap<>();
    Map<Integer, UserSubscribe> userSubscribes = new HashMap<>();


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public long countTwitsByUserName() {
        long count = twits.values().stream()
                .filter(twit -> {
                    return twit.getText().contains("Artem");
                })
                .count();
        return count;
    }

    @Override
    public void fillData() {

        User artem = new User();
        artem.setId(1);
        artem.setName("Artem");

        User mita = new User();
        mita.setId(2);
        mita.setName("Mita");

        User serega = new User();
        serega.setId(3);
        serega.setName("Serega");


        users.put(artem.getId(), artem);
        users.put(mita.getId(), mita);
        users.put(serega.getId(), serega);

        UserSubscribe mitySpyArtem = new UserSubscribe();
        mitySpyArtem.setId(1);
        mitySpyArtem.setUserId(mita.getId());
        mitySpyArtem.setFollowedUserId(artem.getId());
        userSubscribes.put(mitySpyArtem.getId(), mitySpyArtem);

        Random random = new Random();
        for (User user : users.values()) {
            for (int i = 0; i < random.nextInt(100); i++) {
                Twit twit = new Twit();
                twit.setId(atomicInteger.incrementAndGet());
                twit.setText(String.format("some text for %s user with number %s", user.getName(), twit.getId()));
                twits.put(twit.getId(), twit);
            }
        }

    }
}
