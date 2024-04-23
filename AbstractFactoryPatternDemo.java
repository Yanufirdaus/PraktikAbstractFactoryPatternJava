import java.util.Scanner;

interface Mie {
    void masak();
}

class MieAyam implements Mie {
    @Override
    public void masak() {
        System.out.println("Membuat Mie Ayam.");
    }
}

class MieGoreng implements Mie {
    @Override
    public void masak() {
        System.out.println("Membuat Mie Goreng.");
    }
}

interface MieFactory {
    Mie createMieAyam();
    Mie createMieGoreng();
}

class MieJakartaFactory implements MieFactory {
    @Override
    public Mie createMieAyam() {
        return new MieAyam();
    }

    @Override
    public Mie createMieGoreng() {
        return new MieGoreng();
    }
}

class MieBandungFactory implements MieFactory {
    @Override
    public Mie createMieAyam() {
        return new MieAyam();
    }

    @Override
    public Mie createMieGoreng() {
        return new MieGoreng();
    }
}

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih jenis mie (1. Ayam | 2. Goreng):");
        int choice = scanner.nextInt();

        MieFactory factory;

        switch (choice) {
            case 1:
                factory = new MieJakartaFactory();
                break;
            case 2:
                factory = new MieBandungFactory();
                break;
            default:
                throw new IllegalArgumentException("Pilihan tidak valid.");
        }

        Mie mieAyam = factory.createMieAyam();
        Mie mieGoreng = factory.createMieGoreng();

        mieAyam.masak();
        mieGoreng.masak();

        scanner.close();
    }
}
