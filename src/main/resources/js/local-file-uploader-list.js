var Minio = require('minio')

var minioClient = new Minio.Client({
	endPoint: '127.0.0.1',
	port: 9000,
	useSSL: false,
	accessKey: 'CWr0OR6qNKmhFiLg',
	secretKey: 'nEiTxwX1jjIUNEZ0fFipGolyLj0wEXbc'
});

var file = '/Users/loki/Downloads/logo.tar.gz'

var Stream = minioClient.listIncompleteUploads('europetrip', 'logo.tar.gz', false)
Stream.on('data', function(obj) {
	console.log(obj)
})
Stream.on('end', function() {
	console.log('End')
})
Stream.on('error', function(err) {
	console.log(err)
})
