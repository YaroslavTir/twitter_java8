package dao;

import domain.Twit;
import domain.User;
import domain.UserSubscribe;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
    public long countTwitsByUserName(String name) {
        long count = twits.values().stream()
                .filter(twit -> twit.getText().contains(name))
                .count();
        return count;
    }


    @Override
    public List<String> collectList() {
        List<String> list = twits.values().stream()
                .map(twit -> twit.getText())
                .collect(ArrayList::new, List::add, List::addAll);
//                .collect(() -> new ArrayList<String>(),
//                        (a, b) -> a.add(b),
//                        (l1, l2) -> l1.addAll(l2));
        return list;
    }

    @Override
    public Map<Boolean, List<Twit>> mapByName(String name) {
        Map<Boolean, List<Twit>> map = twits.values().stream()
                .collect(Collectors.partitioningBy(twit -> twit.getText().contains(name)));
        return map;
    }

    @Override
    public String stringTextByName(String name) {
        String allTexts = twits.values().stream()
                .map(t -> t.getText())
                .collect(Collectors.joining(";"));
        return allTexts;
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
