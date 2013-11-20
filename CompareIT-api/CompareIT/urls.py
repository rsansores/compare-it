from django.conf.urls import patterns, include, url
from rest_framework import routers
from rest_api import views
import settings

# Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()

# REST-API routers
router = routers.DefaultRouter()
router.register(r'users', views.UserViewSet)
router.register(r'groups', views.GroupViewSet)
router.register(r'products', views.ProductViewSet)
router.register(r'Enterprise', views.EnterpriseViewSet)
router.register(r'Reliability', views.ReliabilityViewSet)
#router.register(r'product_filer', views.ProductFilterViewSet)

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'CompareIT.views.home', name='home'),
    # url(r'^CompareIT/', include('CompareIT.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    url(r'^admin/', include(admin.site.urls)),
    url(r'^rest-api/', include(router.urls)),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework')),
    (r'^media/(?P<path>.*)$', 'django.views.static.serve', {'document_root': settings.MEDIA_ROOT}),
)
