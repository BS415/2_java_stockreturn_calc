import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);

            String ticker;
            double price, beta, marketreturn;

            System.out.println("Please enter the ticker for your stock.");
            ticker = input.nextLine();
            System.out.println("Please enter the current value of your holdings in this security. (in a x.xx format)");
            price = input.nextDouble();
            System.out.println("Please enter the stock's beta. (in a x.xx format)");
            beta = input.nextDouble();
            System.out.println("Please enter the expected annual return of the market. (Out to 2 decimal places, in a xx.xx format)");
            marketreturn = input.nextDouble();

            System.out.printf("Your security with ticker '" + ticker);
            System.out.printf("'");
            System.out.printf(" is currently trading at $" + "%.2f", price);
            System.out.printf(", with a beta of " + "%.2f", beta);
            System.out.printf(".");
            System.out.println();
            System.out.printf("The expected annual market performance is " + "%.2f", marketreturn);
            System.out.println("%.");
            System.out.printf("Based on the beta of the security, it is expected to move ");

            double betacalc = (beta - 1);
            double betalessper = (betacalc * (-100));
            double betaplusper = (betacalc * (100));

            {
                if (beta < 1) {
                    System.out.printf("%.2f", betalessper);
                    System.out.println("% less than the market.");
                }
                if (beta > 1) {
                    System.out.printf("%.2f", betaplusper);
                    System.out.println("% more than the market.");
                } else if (beta == 1) {
                    System.out.println("in parallel with the market.");
                }
            }


            String yesno;
            String timeframe;
            String yesnocase;
            String timeframecase;
            int numdays;
            int numweeks;
            int nummonths;
            int numyears;

            double mktretadj = (marketreturn / 100);

            double returndays = ((mktretadj / 365) * (beta));
            double returnweeks = ((mktretadj / 52) * (beta));
            double returnmonths = ((mktretadj / 12) * (beta));
            double returnyears = ((mktretadj) * (beta));


            Scanner calc = new Scanner(System.in);


            System.out.println("_________________________");
            System.out.println("Would you like to calculate the return of this security? (Yes or No)");
            yesno = input.next();

            yesnocase = yesno.toLowerCase();


            {
                if (yesnocase.equals("yes") || yesnocase.equals("no")) {
                    System.out.println("What time period would you like to calculate the return for? (enter: Days, Weeks, Months or Years)");
                    timeframe = calc.nextLine();
                    timeframecase = timeframe.toLowerCase();

                    if (timeframe.equals("days")) {
                        System.out.println("For how many days would you like to calculate the return? (1 to 365)");
                        numdays = calc.nextInt();

                        double dayRperdec = (returndays * numdays);
                        double dayRper = (dayRperdec * 100);
                        double dayRval = (dayRperdec * price);

                        System.out.printf("Your return for " + numdays);
                        System.out.printf(" days would be $ " + "%.2f", dayRval);

                        {
                            if (dayRper > 0) {
                                System.out.printf(", for a gain of " + "%.2f", dayRper);
                                System.out.println("%.");
                            } else if (dayRper < 0) {
                                System.out.printf(", for a loss of " + "%.2f", (dayRper * -1));
                                System.out.println("%.");
                            }
                        }

                    } else if (timeframe.equals("weeks")) {
                        System.out.println("For how many weeks would you like to calculate the return? (1 to 52)");
                        numweeks = calc.nextInt();

                        double weekRperdec = (returnweeks * numweeks);
                        double weekRper = (weekRperdec * 100);
                        double weekRval = (weekRperdec * price);

                        System.out.printf("Your return for " + numweeks);
                        System.out.printf(" weeks would be $ " + "%.2f", weekRval);

                        {
                            if (weekRper > 0) {
                                System.out.printf(", for a gain of " + "%.2f", weekRper);
                                System.out.println("%.");
                            } else if (weekRper < 0) {
                                System.out.printf(", for a loss of " + "%.2f", (weekRper * -1));
                                System.out.println("%.");
                            }
                        }


                    } else if (timeframe.equals("months")) {
                        System.out.println("How many months return do you want to calculate? (1 to 12)");
                        nummonths = calc.nextInt();

                        double monthRperdec = (returnmonths * nummonths);
                        double monthRper = (monthRperdec * 100);
                        double monthRval = (monthRperdec * price);

                        System.out.printf("Your return for " + nummonths);
                        System.out.printf(" months would be $ " + "%.2f", monthRval);

                        {
                            if (monthRper > 0) {
                                System.out.printf(", for a gain of " + "%.2f", monthRper);
                                System.out.println("%.");
                            } else if (monthRper < 0) {
                                System.out.printf(", for a loss of " + "%.2f", (monthRper * -1));
                                System.out.println("%.");
                            }
                        }


                    } else if (timeframe.equals("years")) {
                        System.out.println("How many years return do you want to calculate? (1 or more)");
                        numyears = calc.nextInt();

                        double yearRperdec = (returnyears * numyears);
                        double yearRper = (yearRperdec * 100);
                        double yearRval = (yearRperdec * price);

                        System.out.println("year RPER dec" + yearRperdec);
                        System.out.println("year RVAL ");

                        System.out.printf("Your return for " + numyears);
                        System.out.printf(" years would be $ " + "%.2f", yearRval);

                        {
                            if (yearRper > 0) {
                                System.out.printf(", for a gain of " + "%.2f", yearRper);
                                System.out.println("%.");
                            } else if (yearRper < 0) {
                                System.out.printf(", for a loss of " + "%.2f", (yearRper * -1));
                                System.out.println("%.");
                            }
                        }


                    }
                } else {
                    System.out.println("Invalid Command");
                    System.out.println();
                }
            }

        }
    }
    }


















