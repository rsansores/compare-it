from django.db import models
from django.contrib.auth.models import User
import datetime

# Create your models here.

class Reliability(models.Model):
    name = models.CharField(max_length=45)

    def __unicode__(self):
        return self.name 

class Enterprise(models.Model):
    name = models.CharField(max_length=45)
    created = models.DateField(default=datetime.datetime.today)
    modified = models.DateTimeField(auto_now_add=True)
    deleted = models.IntegerField()
    description = models.CharField(max_length=50)
    latitude = models.CharField(max_length=100)
    longitude = models.CharField(max_length=100)
   
    def __unicode__(self):
        return self.name 

class Product(models.Model):
    
    YES = 1
    NO  = 0

    DELETED_CHOICES = (
      (YES, 'Yes'),
      (NO, 'No'),
    )
     
    name = models.CharField(max_length=45)
    price = models.DecimalField(max_digits=9, decimal_places=2)
    is_promotion = models.IntegerField(choices=DELETED_CHOICES, default=NO)
    discount = models.DecimalField(max_digits=9, decimal_places=2, default=0)
    created = models.DateField(auto_now_add=True,editable=False)
    modified = models.DateTimeField(auto_now_add=True, default=datetime.datetime.today)
    deleted = models.IntegerField(choices=DELETED_CHOICES, default=NO)
    description = models.CharField(max_length=50)
    ticket_image = models.ImageField(upload_to = 'images/tickets/')  
    product_image = models.ImageField(upload_to = 'images/products/')
    enterprise = models.ForeignKey(Enterprise)
    reliability = models.ForeignKey(Reliability)

    def __unicode__(self):
        return self.name 
