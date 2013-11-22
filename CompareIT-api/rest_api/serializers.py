from django.contrib.auth.models import User, Group
from rest_framework import serializers
from rest_api.models import Product, Enterprise, Reliability

class UserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = User
        fields = ('url', 'username', 'email', 'groups')


class GroupSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Group
        fields = ('url', 'name')


class ProductSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Product
        fields = ('url', 'name', 'price', 'is_promotion', 'discount', 
                  'created', 'deleted', 'description', 'ticket_image',
                  'product_image', 'enterprise', 'reliability',)


class EnterpriseSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Enterprise
        fields = ('url', 'name')

class ReliabilitySerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Reliability
        fields = ('url', 'name')
