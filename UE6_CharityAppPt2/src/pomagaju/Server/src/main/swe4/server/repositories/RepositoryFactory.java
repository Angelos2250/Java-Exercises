package swe4.server.repositories;

public class RepositoryFactory {
    private static UserRepository userRepository = null;
    private static AnnahmestelleRepository annahmestelleRepository = null;
    private static BedarfRepository bedarfRepository = null;
    private static SpendenankündigungRepository spendenankündigungRepository = null;


    private RepositoryFactory() {
        throw new AssertionError("No RepositoryFactory instances for you!");
    }

    public static UserRepository userRepositoryInstance() {
        if(userRepository == null) {
            userRepository = new FakeUserRepository();
        }
        return userRepository;
    }

    public static AnnahmestelleRepository annahmestelleRepositoryInstance() {
        if(annahmestelleRepository == null) {
            annahmestelleRepository = new FakeAnnahmestelleRepository();
        }
        return annahmestelleRepository;
    }

    public static BedarfRepository BedarfRepositoryInstance() {
        if(bedarfRepository == null) {
            bedarfRepository = new FakeBedarfRepository();
        }
        return bedarfRepository;
    }

    public static SpendenankündigungRepository spendenankündigungRepositoryInstance() {
        if(spendenankündigungRepository == null) {
            spendenankündigungRepository = new FakeSpendenankündigungRepository();
        }
        return spendenankündigungRepository;
    }
}
