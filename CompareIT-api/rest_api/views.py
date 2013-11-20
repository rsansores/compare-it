from django.contrib.auth.models import User, Group
from rest_framework import viewsets
from rest_api.serializers import UserSerializer, GroupSerializer, ProductSerializer, EnterpriseSerializer, ReliabilitySerializer
from rest_api.models import Product, Enterprise, Reliability
from rest_framework import generics
from rest_framework import filters

class UserViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = User.objects.all()
    serializer_class = UserSerializer


class GroupViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.
    """
    queryset = Group.objects.all()
    serializer_class = GroupSerializer

class ProductViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.                                                             
    """
    queryset  = Product.objects.all()
    serializer_class = ProductSerializer

class EnterpriseViewSet(viewsets.ModelViewSet):
    """                                                                                                                                                                                                                                
    API endpoint that allows groups to be viewed or edited.                                                                                                                                                                            
    """
    queryset  = Enterprise.objects.all()
    serializer_class = EnterpriseSerializer

class ReliabilityViewSet(viewsets.ModelViewSet):
    """                                                                                                                                                                                                                                
    API endpoint that allows groups to be viewed or edited.                                                                                                                                                                            
    """
    queryset  = Reliability.objects.all()
    serializer_class = ReliabilitySerializer

class ProductFilterViewSet(generics.ListAPIView):
    queryset = Product.objects.all()
    serializer = ProductSerializer
    filter_backends = (filters.SearchFilter,)
    search_fields = ('name', 'price')
