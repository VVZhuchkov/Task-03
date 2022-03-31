package com.github.vvzhuchkov.task03.entity;

import java.util.Objects;

public class Speakers extends Appliance {
    private final int powerConsumption;
    private final int numberOfSpeakers;
    private final String frequencyRange;
    private final double cordLength;

    private Speakers(SpeakersBuilder speakersBuilder) {
        super(speakersBuilder.getBrand(), speakersBuilder.getModel(), speakersBuilder.getPrice());
        this.powerConsumption = speakersBuilder.getPowerConsumption();
        this.numberOfSpeakers = speakersBuilder.getNumberOfSpeakers();
        this.frequencyRange = speakersBuilder.getFrequencyRange();
        this.cordLength = speakersBuilder.getCordLength();
    }

    public static class SpeakersBuilder {
        private final String brand;
        private final String model;
        private final double price;
        private int powerConsumption = 0;
        private int numberOfSpeakers = 0;
        private String frequencyRange = null;
        private double cordLength = 0;

        public SpeakersBuilder(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }

        public int getPowerConsumption() {
            return powerConsumption;
        }

        public SpeakersBuilder setPowerConsumption(int powerConsumption) {
            this.powerConsumption = powerConsumption;
            return this;
        }

        public int getNumberOfSpeakers() {
            return numberOfSpeakers;
        }

        public SpeakersBuilder setNumberOfSpeakers(int numberOfSpeakers) {
            this.numberOfSpeakers = numberOfSpeakers;
            return this;
        }

        public String getFrequencyRange() {
            return frequencyRange;
        }

        public SpeakersBuilder setFrequencyRange(String frequencyRange) {
            this.frequencyRange = frequencyRange;
            return this;
        }

        public double getCordLength() {
            return cordLength;
        }

        public SpeakersBuilder setCordLength(double cordLength) {
            this.cordLength = cordLength;
            return this;
        }

        public Speakers build() {
            return new Speakers(this);
        }
    }

    @Override
    public String toString() {
        return "Speakers {" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return powerConsumption == speakers.powerConsumption && numberOfSpeakers == speakers.numberOfSpeakers
                && Double.compare(speakers.cordLength, cordLength) == 0
                && frequencyRange.equals(speakers.frequencyRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
    }
}