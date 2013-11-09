from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class Reliability(models.Model):
	name = models.CharField(max_length=45)

class Enterprise(models.Model):
	name = models.CharField(max_length=45)
	created = models.DateField()
	modified = models.DateTimeField(auto_now_add=True)
	deleted = models.IntegerField()
	description = models.CharField(max_length=50)
	latitude = models.CharField(max_length=100)
	longitude = models.CharField(max_length=100)

class Product(models.Model):
	name = models.CharField(max_length=45)
	price = models.DecimalField(max_digits=9, decimal_places=2)
	isPromotion = models.IntegerField()
	discount = models.DecimalField(max_digits=9, decimal_places=2)
	created = models.DateField()
	modified = models.DateTimeField(auto_now_add=True)
	deleted = models.IntegerField()
	description = models.CharField(max_length=50)
	ticketImage = models.CharField(max_length=100)
	objectImage = models.CharField(max_length=100)
	enterpriseId = models.ForeignKey(Enterprise)
	reliabilityId = models.ForeignKey(Reliability)
