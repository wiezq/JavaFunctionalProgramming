package module41_HandlingCollections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.computeIfPresent(name,
                (nam, phoneNumbers) ->
                        Stream.concat(
                                phoneNumbers.stream(),
                                numbers.stream()).collect(Collectors.toList())
        );
        nameToPhoneNumbersMap.putIfAbsent(name, numbers);

    }

    public void printPhoneBook() {
        nameToPhoneNumbersMap.forEach((name, numbers) -> {
            System.out.println(name);
            numbers.forEach(n -> {
                System.out.printf("%s: %s\n", n.getType().name(), n.getNumber());

            });
        });
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

        List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        phoneBook.printPhoneBook();
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}