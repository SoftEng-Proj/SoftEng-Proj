package com.Software.FitnessSystem.InstructorControllers;

public class Program {
	
        private String name;
        private String duration;
        private String level;
        private String goal;
        private String links;
        private String price;
        private String schedule;

        public Program(String name, String duration, String level, String goal, String links, String price) {
            this.name = name;
            this.duration = duration;
            this.level = level;
            this.goal = goal;
            this.links = links;
            this.price = price;
            this.schedule="Not set yet";
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getGoal() {
            return goal;
        }

        public void setGoal(String goal) {
            this.goal = goal;
        }

        public String getLinks() {
            return links;
        }

        public void setLinks(String links) {
            this.links = links;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
        
        public String getSchedule() {
            return schedule;
        }

        public void setSchedule(String schedule) {
            this.schedule = schedule;
        }
	}


