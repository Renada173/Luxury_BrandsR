package com.example.luxury_brands;

    enum ErrorCodes
    {
        IncorrectAuth, FieldsEmpty, True, False
    }

    public class Utilities {

        private static Utilities instance;

        public Utilities()
        {}

        public static Utilities getInstance()
        {
            if (instance == null)
                instance = new Utilities();

            return instance;
        }

        public boolean validateEmail(String email)
        {
            return true;
        }

        public boolean validatePassword(String password)
        {
            return true;
        }

        public boolean checkTrimEmpty(String text)
        {
            return text.trim().isEmpty();
        }
    }
