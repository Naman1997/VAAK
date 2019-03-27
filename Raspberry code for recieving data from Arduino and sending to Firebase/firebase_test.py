# This file is to check if you can connect to your firebase database properly or not
# If your "Realtime Database" should be updated after running this script
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db

cred = credentials.Certificate('#Location_of_your_private_key_generated_in_firebase(a json file)')
# You can generate the file for this @Project Settings(Icon next to Project Overview) > Service Accounts > Generate new private key
# It will be a json file

default_app = firebase_admin.initialize_app(cred)
#Remove or comment the line above after your first run

firebase_admin.initialize_app(cred, {
    'databaseURL': '#Link_to_your_realtime_database'
    # You can find your link after creating your realtime database.
    # You can find it by going to Develop > Database >Realtime Database > (copy the link in the form "https://Project-name.firebaseio.com")
})

ref = db.reference()
#Use ref.update() for updating existing record
ref.set({
    'asd':'M'
})